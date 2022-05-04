package review_dataStructure_algorithm;

import java.util.HashMap;
import java.util.LinkedList;

//회사에 여러개의 프로젝트가 있는데 어떤 프로젝트들은 특정 프로젝트가 완료되어야만
//진행할 수 있는 프로젝트가 있다. 프로젝트의 목록과 각 프로젝트간 의존여부를
//넘겨주면 의존도에 입각한 프로젝트의 진행순서를 반환하는 함수를 구현하시오

//projects : a,b,c,d,e,f,g
//의존도는 (f,a)에서 앞에있는 f가 실행되야 뒤에있는 a가 실행가능하다는 이야기
//dependencies: (f,a),(f,b),(f,c),(b,a)
//				(c,a),(a,e),(b,e)(d,g)
//노드간의 관계를 명시하는 데이터를 표현할 때는 Graph의 개념을 사용하는게 좋다.
//그래프를 자료구조에 저장하는 방법에는 2가지가 있다.
//1. Matrix
//2. LinkedList
//여기서는 공간효율이 좋은 LinkedList를 사용한다.

// 1. 우선 배열을 선언하여 프로젝트를 담는다. 각 노드들의 의존도를 배열의 노드에 추가해준다. 
// 	  이때 (f,a)를 예로 f에 a를 연결하도록 구현하는게아니라
//    a에 f를 연결시킨다.(자신이 실행되기위해 먼저 실행되야할 노드를 연결시켜준다.)

//dependencies: (f,a),(f,b),(f,c),(b,a)
//				(c,a),(a,e),(b,e)(d,g)

//배열|  연결리스트로 노드 연결
// a | -> f -> b -> c
// b | -> f
// c | -> f
// d | 
// e | -> a -> b
// f |
// g | -> d

// 2. 이제 모든 프로젝트들을 의존성에 입각하여 순서대로 가져와야함
// 3. 결과를 저장할 result[] 배열을 만든다.(프로젝트 수와 동일한 길이)
// 4. 배열방에 프로젝트를 추가할 함수 F()를 만든다.
// 5. LinkedList를 연결한 배열방을 처음부터 끝까지 모든 프로젝트를 돌면서 F()를 호출한다. 
// 6. F()를 호출하면 결과를 result[]에 바로 추가하지 않고 해당 프로젝트보다 먼저 실행되야하는 
//    프로젝트가 있는지 확인한다. 있으면 해당 프로젝트들을 loop 돌면서 F()호출한다.
/*
호출되는 순서와 재귀, 결과 배열은 아래와 같다.

배열의 가장 앞에있는 a부터 호출한다.
F(a) 	//a를 실행하려고 보니 f -> b -> c가 먼저 실행되야함(재귀 시작) 재귀가 끝나면 [a출력]
 F(f)	//f는 선행조건이 없으므로 [f출력]
 F(b)	//f다음 b실행 b도 f가 선행조건인데 이미 f는 실행됐으므로 [b출력]
 F(c)	//b다음 c실행 c도 f가 선행조건 f는 이미 실행됐으므로 [c출력] (재귀 종료)
F(d)	//a를 호출하면서 b, c, f가 이미 호출되었으므로 d의 순서이다. 선행 프로젝트가 없으므로 [d출력]
F(e)	//e를 호출하는데 선행조건인 a,b가 이미 처리됐으므로 [e출력]
F(g)	//f는 이미 처리됐으므로 g를 호출한다. 선행조건 d도 처리됐으므로 [d출력]

결과 배열에 추가된 순서는 아래와 같다.
| f | b | c | a | d | e | g |
  
*/

class Project{
	private String name;
	private LinkedList<Project> dependencies; //우선 처리되어야 할 프로젝트의 리스트를 저장할 참조변수
	private boolean marked; //결과 배열에 담았는지 마킹할 flag
	public Project(String name) {
		this.name = name;
		this.marked = false;
		this.dependencies = new LinkedList <Project>(); //의존하는 프로젝트의 리스트를 담을 연결리스트 생성
	}
	public void addDependency(Project project) {//의존관계를 추가해주는 함수
		if(!dependencies.contains(project)) {//먼저처리해야할 프로젝트를 받아서 LinkedList에 추가함
			dependencies.add(project);
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LinkedList<Project> getDependencies() {
		return dependencies;
	}
	public void setDependencies(LinkedList<Project> dependencies) {
		this.dependencies = dependencies;
	}
	public boolean isMarked() {
		return marked;
	}
	public void setMarked(boolean marked) {
		this.marked = marked;
	}
}

class ProjectManager { //프로젝트를 관리하는 클래스
	//프로젝트명으로 검색할 때 시간단축을 위해 배열대신 HashMap사용
	private HashMap<String, Project> projects;
	public ProjectManager(String[] names, String[][] dependencies) {
		buildProjects(names);
		addDependencies(dependencies);
	}
	
	public void buildProjects(String[] names) {
		projects = new HashMap<String,Project>();
		for(int i = 0; i< names.length; i++) {
			projects.put(names[i], new Project(names[i]));
		}
	}
	
	public void addDependencies(String[][] dependencies) {
		for(String[] dependency : dependencies) {
			Project before = findProject(dependency[0]);
			Project after = findProject(dependency[1]);
			after.addDependency(before);
		}
	}
	
	private int index;
	public Project[] buildOrder() {
		initMarkingFlages();
		Project[] ordered = new Project[this.projects.size()];
		index = 0;
		for(Project project : this.projects.values()) {
			buildOrder(project, ordered);
		}
		return ordered;
	}
	
	public void buildOrder(Project project, Project[] ordered) {
		if(!project.getDependencies().isEmpty()) {
			for(Project p : project.getDependencies()) {
				buildOrder(p, ordered);
			}
		}
		if(project.isMarked() == false) {
			project.setMarked(true);
			ordered[index] = project;
			index++;
		}
	}
	
	private void initMarkingFlages() {
		for(Project project : this.projects.values()) {
			project.setMarked(false);
		}
	}
	
	public Project findProject(String name) {
		return projects.get(name);
	}
}

public class Graph01 {
	public static void main(String[] args) {
		String[] projects = {"a", "b", "c", "d", "e", "f", "g"};
		String[][] dependencies = {
				{"f", "a"}, {"f", "b"}, {"f", "c"}, {"b", "a"},
				{"c", "a"}, {"a", "e"}, {"b", "e"}, {"d", "g"}
				};
		
		ProjectManager pm = new ProjectManager(projects, dependencies);
		Project[] ps = pm.buildOrder();
		for(Project p : ps) {
			if(p != null) {
				System.out.print(p.getName() + " ");
			}
		}
		
		
	}
}






























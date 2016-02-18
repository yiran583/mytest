package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年12月10日 下午3:23:08
 */

class Student {
	String name;
	String age;

	public Student() {};

	public Student(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}

public class Queue {
	public static void offerAll(ConcurrentLinkedQueue<Student> queue,List<Student> list){
		for(Student s : list){
			queue.offer(s);
		}
	}
	public static void main(String[] args) {
		ConcurrentLinkedQueue<Student> queue = new ConcurrentLinkedQueue<Student>();
		List<Student> list = new ArrayList<Student>();
		Student s1 = new Student("1","1");
		Student s2 = new Student("2","2");
		Student s3 = new Student("3","3");
		Student s4 = new Student("4","4");
		Student s5 = new Student("5","5");
		list.add(s1);
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);
		offerAll(queue, list);
		System.out.println(queue.contains(s2));
		Student s = list.get(1);
		System.out.println(queue.contains(s));
		System.out.println(s.equals(s2));
		queue.remove(s2);
		System.out.println(queue.contains(s));
	}
}

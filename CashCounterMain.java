package com.bridgelabz;

class Person {
	Person nextPerson;
	int money;
	int bankBalance = 1000;
	public Person( int money) {
		this.nextPerson = null;
		this.money = money;
		CashCounter.noOfCustomers++;
	}
}

class CashCounter {

	Person head;
	static int noOfCustomers;

	public boolean isEmpty() {
		if(head == null) {
			return true;
		}
		return false;
	}

	private void addLast(int money) {
		Person person = new Person(money);
		noOfCustomers--;
		if (isEmpty()) {
			head = person;
			head.bankBalance += head.money;
			noOfCustomers++;
			return;
		}

		Person currPerson = head;
		while (currPerson.nextPerson != null) {
			currPerson = currPerson.nextPerson;
		}
		currPerson.nextPerson = new Person(money);
		currPerson.nextPerson.bankBalance += currPerson.nextPerson.money;
	}
	public void enqueue(int money) {
		addLast(money);
	}

	private void deleteFirst() {
		if (isEmpty()) {
			return;
		}
		head = head.nextPerson;
		noOfCustomers--;
	}

	public void dequeue() {
		deleteFirst();
	}

	public int noOfPersonInQueue() {
		System.out.println();
		return noOfCustomers;
	}
}


public class CashCounterMain {

	public static void main(String[] args) {
		CashCounter counter = new CashCounter();
		counter.enqueue(500);
		counter.enqueue(1000);
		counter.enqueue(200);
		counter.enqueue(400);
		counter.dequeue();
		counter.dequeue();
		System.out.println(counter.noOfPersonInQueue());

	}
}

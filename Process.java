package so;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import so.memory.AdressMemory;

public class Process {
	private int sizeInMemory;
	private String id;
	private AdressMemory am;

	// segunda
	/*
	 * private int timeToExecute; private int numberOfInstructions; private
	 * List<Process> processes;
	 */

	public Process(int tam) {
		this.id = UUID.randomUUID().toString();
		Random rand = new Random();
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 6, 10, 20, 30, 50, 100);
		// this.sizeInMemory = numbers.get(rand.nextInt(numbers.size()));
		this.sizeInMemory = tam;

	}

	public int getSizeInMemory() {
		return sizeInMemory;
	}

	public void setSizeInMemory(int sizeInMemory) {
		this.sizeInMemory = sizeInMemory;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public AdressMemory getAm() {
		return am;
	}

	public void setAm(AdressMemory am) {
		this.am = am;
	}

}

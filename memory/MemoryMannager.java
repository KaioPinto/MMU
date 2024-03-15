package so.memory;

import java.util.Iterator;

import so.Process;

public class MemoryMannager {
	private String[] memoryPhysic;
	private Strategy strategy;

	/* private String[] memoryLogic; */

	public MemoryMannager(Strategy strategy) {
		this.memoryPhysic = new String[128];
		this.strategy = strategy;
	}

	public void write(Process p) {
		if (this.strategy.equals(Strategy.FIRST_FIT)) {
			this.writeWithFirstFit(p);

		} else if (this.strategy.equals(Strategy.BEST_FIT)) {
			this.writeWithBestFit(p);

		} else if (this.strategy.equals(Strategy.WORST_FIT)) {
			this.writeWithWorstFit(p);

		}

	}

	private void writeWithBestFit(Process p) {

		int bestSize = -1;
		int actualSize = 0;
		int actualBestSize = 0;
		System.out.println("processo" + p.getSizeInMemory());

		for (int i = 0; i < this.memoryPhysic.length; i++) {
			if (this.memoryPhysic[i] == null) {
				actualSize++;

				if (i == this.memoryPhysic.length - 1) {
					bestSize = i - actualSize + 1;
					if (actualSize < p.getSizeInMemory()) {
						bestSize = -1;

					}
				}

			} else {

				if ((actualSize - 1) == p.getSizeInMemory()) {
					bestSize = i - actualSize + 1;
					break;

				} else if (actualSize > p.getSizeInMemory() && actualSize < actualBestSize
						|| i == this.memoryPhysic.length - 1) {

					bestSize = (i - actualSize) + 1;

				} else if (actualSize > p.getSizeInMemory()) {
					actualBestSize = (i - actualSize) + 1;
					bestSize = actualBestSize;

				}
				actualSize = 0;
			}

		}
		System.out.println();
		if (bestSize == 0 || bestSize > 0) {
			System.out.println("entreando");
			int start = bestSize;
			int end = start + p.getSizeInMemory();
			AdressMemory address = new AdressMemory(start, end);
			for (int i = address.getStart(); i < address.getEnd(); i++) {
				this.memoryPhysic[i] = p.getId();
				System.out.println(i);
			}
		} else {
			System.out.println("Não há espaço disponível");
		}

	}

	private void writeWithWorstFit(Process p) {
		int bigerSize = -1;
		int actualSize = 0;
		System.out.println("processo:" + p.getSizeInMemory());
		for (int i = 0; i < memoryPhysic.length; i++) {
			if (this.memoryPhysic[i] != null) {
				if (actualSize > bigerSize && actualSize >= p.getSizeInMemory()) {
					bigerSize = (i - actualSize) + 1;
					actualSize = 0;
				} else {
					actualSize = 0;
				}

			} else {
				actualSize++;
				if (this.memoryPhysic.length - 1 == i) {
					if (actualSize > bigerSize) {
						bigerSize = (i - actualSize) + 1;
					}

				}

			}

		}
		if (bigerSize == 0 || bigerSize > 0) {
			int start = bigerSize;
			int end = start + p.getSizeInMemory();
			AdressMemory address = new AdressMemory(start, end);
			for (int i = address.getStart(); i < address.getEnd(); i++) {
				this.memoryPhysic[i] = p.getId();
				System.out.println(i);
			}

		} else {
			System.out.println("Não há espaço disponível");
		}
	}

	private void writeWithFirstFit(Process p) {
		int actualSize = 0;
		System.out.println("Tamanho do processo: " + p.getSizeInMemory());
		for (int i = 0; i < memoryPhysic.length; i++) {
			if (this.memoryPhysic[i] == null) {
				actualSize++;
				if (actualSize == p.getSizeInMemory()) {
					int start = (i - actualSize) + 1;
					int end = i;
					AdressMemory address = new AdressMemory(start, end);
					System.out.println("Escrevendo na memoria");
					for (int ind = address.getStart(); ind <= address.getEnd(); ind++) {
						System.out.println(ind);
						this.memoryPhysic[ind] = p.getId();
					}
					break;
				}

			} else if (this.memoryPhysic[i] != null || actualSize != p.getSizeInMemory()) {
				actualSize = 0;
			}
		}
		if (actualSize < p.getSizeInMemory()) {
			System.out.println("Não há espaço");
		}
	}

	private void printMemoryStatus() {
		for (int i = 0; i < memoryPhysic.length; i++) {
			System.out.print(memoryPhysic[i] + " | ");
		}

	}

	public void delete(Process p) {
		System.out.println("Excluidno processos:");

		for (int i = 0; i < this.memoryPhysic.length; i++) {
			if (this.memoryPhysic[i] == p.getId()) {
				System.out.println(i);
				this.memoryPhysic[i] = null;

			} else {
			}
		}

	}
}

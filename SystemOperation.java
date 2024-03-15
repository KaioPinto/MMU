package so;

import so.cpu.CpuManager;
import so.memory.MemoryMannager;
import so.memory.Strategy;
import so.scheluder.Scheluder;

public class SystemOperation {
	private static MemoryMannager mm;
	private static CpuManager cm;
	private static Scheluder scheluder;

	public static Process systemCall(SystemCallType type, Process p) {
		if (type.equals(SystemCallType.OPEN_PROCESS)) {
			if (mm == null) {
				mm = new MemoryMannager(Strategy.WORST_FIT);
			}
			if (cm == null) {
				cm = new CpuManager();

			}
			return p;

		} else if (type.equals(SystemCallType.WRITE_PROCESS)) {
			mm.write(p);
		}

		else if (type.equals(SystemCallType.CLOSE_PROCESS)) {
			mm.delete(p);
		}

		return null;
	}

}
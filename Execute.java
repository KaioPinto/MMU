package so;

public class Execute {

	public static void main(String[] args) {

		Process p1 = SystemOperation.systemCall(SystemCallType.OPEN_PROCESS, new Process(20));
		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p1);
		Process p2 = SystemOperation.systemCall(SystemCallType.OPEN_PROCESS, new Process(38));
		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p2);
		Process p3 = SystemOperation.systemCall(SystemCallType.OPEN_PROCESS, new Process(38));
		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p3);
		Process p4 = SystemOperation.systemCall(SystemCallType.OPEN_PROCESS, new Process(20));
		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p4);
		SystemOperation.systemCall(SystemCallType.CLOSE_PROCESS, p2);
		Process p6 = SystemOperation.systemCall(SystemCallType.OPEN_PROCESS, new Process(8));
		SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p6);
		// Process p5 = SystemOperation.systemCall(SystemCallType.OPEN_PROCESS, new
		// Process(40));
		// SystemOperation.systemCall(SystemCallType.WRITE_PROCESS, p5);

	}

}

package scale;

import adapter.BuildAuto;


public class EditOptions extends Thread {

	
	String automobileKey, optionSetName, optionName, optionNameNew;
	int operationNumber, threadNumber;
	adapter.ProxyAutomobile proxyAutomobile;
	String[] inputArguments;
	boolean asynchronousFlag_;


	public EditOptions(adapter.ProxyAutomobile proxyAutomobile_, int operationNumber_, int threadNumber_,
		boolean asynchronousFlag, String[] inputArguments_) {
		proxyAutomobile = proxyAutomobile_;
		operationNumber = operationNumber_;
		threadNumber = threadNumber_;
		asynchronousFlag_ = asynchronousFlag;
		inputArguments = inputArguments_;
	}

	public void run() {
		if (asynchronousFlag_) {
			runAsynchronous();
		} else {
			runSynchronous();
		}
	}

	public void runAsynchronous() {
		proxyAutomobile.threadAvailable = false;
		switch (operationNumber) {
		case 0:
			System.out.println("Start thread " + threadNumber + ", Method: updateOptionName");
			if (inputArguments.length > 3) {
				proxyAutomobile.updateOptionName(inputArguments[0], inputArguments[1], inputArguments[2],
					inputArguments[3]);
			}
			break;
		case 1:
			System.out.println("Start thread " + threadNumber + ", Method: updateOptionSetName");
			if (inputArguments.length > 2) {
				proxyAutomobile.updateOptionSetName(inputArguments[0], inputArguments[1], inputArguments[2]);
			}
			break;
		case 2:
			System.out.println("Start thread " + threadNumber + ", Method: updateOptionSetPrice");
			break;
		case 3:
			System.out.println("Start thread " + threadNumber + ", Method: setOptionChoice");
			if (inputArguments.length > 2) {
				proxyAutomobile.setOptionChoice(inputArguments[0], inputArguments[1], inputArguments[2]);
			}
			break;
		}
		System.out.println("Stopping thread " + threadNumber);
	}

	public void runSynchronous() {
		synchronized (proxyAutomobile) {
			proxyAutomobile.threadAvailable = false;
			switch (operationNumber) {
			case 0:
				System.out.println("Start thread " + threadNumber + ", Method: updateOptionName");
				if (inputArguments.length > 3) {
					proxyAutomobile.updateOptionName(inputArguments[0], inputArguments[1], inputArguments[2],
						inputArguments[3]);
				}
				break;
			case 1:
				System.out.println("Start thread " + threadNumber + ", Method: updateOptionSetName");
				if (inputArguments.length > 2) {
					proxyAutomobile.updateOptionSetName(inputArguments[0], inputArguments[1], inputArguments[2]);
				}
				break;
			case 2:
				System.out.println("Start thread " + threadNumber + ", Method: updateOptionSetPrice");
				break;
			case 3:
				System.out.println("Start thread " + threadNumber + ", Method: setOptionChoice");
				if (inputArguments.length > 2) {
					proxyAutomobile.setOptionChoice(inputArguments[0], inputArguments[1], inputArguments[2]);
				}
				break;
			}
			System.out.println("Stopping thread " + threadNumber);
		}
	}
}
package co.setu.biller_system.model;

public class ResponseMessage {
	private String status;
	private Object data;

	public ResponseMessage() {
		super();
	}

	public ResponseMessage(String status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", data=" + data + "]";
	}

}

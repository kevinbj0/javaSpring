package db.test.api;




public class AirDTO {
	String informCause;
	String dataTime;
	String informGrade;

	public AirDTO() {
		// TODO Auto-generated constructor stub
	}

	public AirDTO(String informCause, String dataTime, String informGrade) {
		super();
		this.informCause = informCause;
		this.dataTime = dataTime;
		this.informGrade = informGrade;
	}

	public String getInformCause() {
		return informCause;
	}

	public void setInformCause(String informCause) {
		this.informCause = informCause;
	}

	public String getDataTime() {
		return dataTime;
	}

	public void setDataTime(String dataTime) {
		this.dataTime = dataTime;
	}

	public String getInformGrade() {
		return informGrade;
	}

	public void setInformGrade(String informGrade) {
		this.informGrade = informGrade;
	}

	@Override
	public String toString() {
		return "AirDTO [informCause=" + informCause + ", dataTime=" + dataTime + ", informGrade=" + informGrade + "]";
	}
	
	
	
}

package cf.honeypot.Models;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Event {
	@Id
	private Long id;

	private LocalDateTime dateTime;

	@NotNull
	private String sourceAddress;

	private String destAddress;

	private String protocol;

	private String destPort;

	private String flag;

	private String summary;


	private Long packetNum;

	public Event(){}

	public Long getId(){return id;}

	public void setId(Long id){this.id = id;}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public String getDestAddress() {
		return destAddress;
	}

	public void setDestAddress(String destAddress) {
		this.destAddress = destAddress;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getDestPort() {
		return destPort;
	}

	public void setDestPort(String destPort) {
		this.destPort = destPort;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Long getPacketNum() {
		return packetNum;
	}

	public void setPacketNum(Long packetNum) {
		this.packetNum = packetNum;
	}
}

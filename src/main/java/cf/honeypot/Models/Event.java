package cf.honeypot.Models;


import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Event {
	@Id
	private Long id;

	@NotNull
	private String sourceIp;

	@NotNull
	private String content;

	public Event(){}

	public Long getId(){return id;}

	public void setId(Long id){this.id = id;}

	public String getSourceIp(){return sourceIp;}

	public void setSourceIp(String sourceIp){this.sourceIp = sourceIp;}

	public String getContent(){return content;}

	public void setContent(String content){this.content = content;}

}

package org.jboss.esb.samples;

public class LoggerMessage {

    private String firstname;
    private String lastname;
    private String body;

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

    @Override
    public String toString() {
        return "Mssg:" + firstname + " " + lastname + ", body:" + body;
    }
}

package model;

public class Member {
	
	private String id;
	private String pass;
	private String name;
	private String email;
	private String contact;

	 public String getid() {
	        return id;
	    }
	    public void setid(String id) {
	        this.id = id;
	    }
	    public String getpass() {
	        return pass;
	    }
	    public void setpass(String pass) {
	        this.pass = pass;
	    }
	    public String getname() {
	        return name;
	    }
	    public void setname(String name) {
	        this.name = name;
	    }
	    public String getemail() {
	        return email;
	    }
	    public void setemail(String email) {
	        this.email = email;
	    }
		public String getcontact() {
			// TODO Auto-generated method stub
			return contact;
		}
		public void setcontact(String string) {
			this.contact = contact;
			
		}
	    @Override
	    public String toString() {
	        return "Member [id=" + id + ", pass=" + pass + ", name=" + name + ", email=" + email + "]";
	    }


}

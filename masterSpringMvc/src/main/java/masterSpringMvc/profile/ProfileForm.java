package masterSpringMvc.profile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import masterSpringMvc.dates.PastLocalDate;

public class ProfileForm {
	//@Size(min = 2)
	@Size(min = 2, message = "Please specify a valid twitter handle")
	private String twitterHandle;
	
	@Email
	@NotEmpty
	private String email;
	
	@NotNull
	@PastLocalDate
	private LocalDate birthDate;
	
	@NotEmpty
	private List<String> tastes = new ArrayList<>();

	public String getTwitterHandle() {
		return twitterHandle;
	}

	public void setTwitterHandle(String twitterHandle) {
		this.twitterHandle = twitterHandle;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<String> getTastes() {
		return tastes;
	}

	public void setTastes(List<String> tastes) {
		this.tastes = tastes;
	}

	@Override
	public String toString() {
		return "ProfileForm [twitterHandle=" + twitterHandle + ", email=" + email + ", birthDate=" + birthDate
				+ ", tastes=" + tastes + "]";
	}	

}

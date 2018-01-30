package org.lacos.baby.user;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.lacos.baby.permission.PermissionEntity;
import org.lacos.baby.utils.BaseEntity;



@Entity
@Table(name = "tb_user")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class UserEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 201602010251L;





	@NotNull(message="Campo name esta vazio!!!")
	@Size(min = 4, max = 120, message="min 4.. max 120")
	@Column(name = "name", length = 120, nullable = false)
	private String name;




	@Email
	@NotNull(message="Campo E-mail esta vazio!!!")
	@NotEmpty
	@Pattern(regexp = "^[\\w\\-]+(\\.[\\w\\-]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$", message="E-mail com formato incorreto.")
	@Column(name = "email", length = 255, nullable = false, unique=true)
	private String email;

	@NotNull
	@Size(min = 80, max = 80)
	@Column(name = "password", length = 80, nullable = false)
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_user_permission", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "permission_id") )
	private List<PermissionEntity> permissions;


	@Column(name = "mime_type", nullable = true)
	private String mimeType;

	//@Lob
	@Type(type="org.hibernate.type.BinaryType")
	private byte[] file;



	public UserEntity() {
	}



	public UserEntity(String name, String email, String password, List<PermissionEntity> permissions, String mimeType,
			byte[] file) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.permissions = permissions;
		this.mimeType = mimeType;
		this.file = file;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public List<PermissionEntity> getPermissions() {
		return permissions;
	}



	public void setPermissions(List<PermissionEntity> permissions) {
		this.permissions = permissions;
	}



	public String getMimeType() {
		return mimeType;
	}



	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}



	public byte[] getFile() {
		return file;
	}



	public void setFile(byte[] file) {
		this.file = file;
	}


}

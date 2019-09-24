package top.coolidea.security.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LaboratoryUser implements Serializable, UserDetails {
    private Integer userid;

    private Integer usertypeid;

    private String username;

    private String password;

    private Date registetime;

    private Boolean alowable;

    private String remark;
    private Collection<? extends GrantedAuthority> authorities;

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    private String roles;

    public Integer getIdentityid() {
        return identityid;
    }

    public void setIdentityid(Integer identityid) {
        this.identityid = identityid;
    }

    private Integer identityid;

    private static final long serialVersionUID = 1L;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getUsertypeid() {
        return usertypeid;
    }

    public void setUsertypeid(Integer usertypeid) {
        this.usertypeid = usertypeid;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getRegistetime() {
        return registetime;
    }

    public void setRegistetime(Date registetime) {
        this.registetime = registetime;
    }

    public Boolean getAlowable() {
        return alowable;
    }

    public void setAlowable(Boolean alowable) {
        this.alowable = alowable;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LaboratoryUser other = (LaboratoryUser) that;
        return (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
                && (this.getUsertypeid() == null ? other.getUsertypeid() == null : this.getUsertypeid().equals(other.getUsertypeid()))
                && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
                && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
                && (this.getRegistetime() == null ? other.getRegistetime() == null : this.getRegistetime().equals(other.getRegistetime()))
                && (this.getAlowable() == null ? other.getAlowable() == null : this.getAlowable().equals(other.getAlowable()))
                && (this.getIdentityid() == null ? other.getIdentityid() == null : this.getIdentityid().equals(other.getIdentityid()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUsertypeid() == null) ? 0 : getUsertypeid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getRegistetime() == null) ? 0 : getRegistetime().hashCode());
        result = prime * result + ((getAlowable() == null) ? 0 : getAlowable().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getIdentityid() == null) ? 0 : getIdentityid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", usertypeid=").append(usertypeid);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", registetime=").append(registetime);
        sb.append(", alowable=").append(alowable);
        sb.append(", remark=").append(remark);
        sb.append(", identityid=").append(identityid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }


    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
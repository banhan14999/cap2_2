package craftvillage.datalayer.entities;
// Generated Mar 24, 2020, 3:56:15 PM by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import craftvillage.corelayer.utilities.ConstantParameter;

/**
 * AdProvince generated by hbm2java
 */
@Entity
@Table(name = "ad_province", schema = ConstantParameter._SCHEMA_NAME)
public class AdProvince implements java.io.Serializable {

	private int provinceId;
	private AdCountry adCountry;
	private String provinceCode;
	private String provinceName;
	@JsonIgnore
	private Set<AdDistrict> adDistricts = new HashSet<AdDistrict>(0);

	public AdProvince() {
	}

	public AdProvince(int provinceId) {
		this.provinceId = provinceId;
	}

	public AdProvince(int provinceId, AdCountry adCountry, String provinceCode, String provinceName,
			Set<AdDistrict> adDistricts) {
		this.provinceId = provinceId;
		this.adCountry = adCountry;
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
		this.adDistricts = adDistricts;
	}
	
	@Id
	@Column(name = "PROVINCE_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public int getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY_ID")
	public AdCountry getAdCountry() {
		return this.adCountry;
	}

	public void setAdCountry(AdCountry adCountry) {
		this.adCountry = adCountry;
	}

	@Column(name = "PROVINCE_CODE", length = 20)
	public String getProvinceCode() {
		return this.provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	@Column(name = "PROVINCE_NAME", length = 50)
	public String getProvinceName() {
		return this.provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	@OrderBy("districtId ASC")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "adProvince")
	public Set<AdDistrict> getAdDistricts() {
		return this.adDistricts;
	}

	public void setAdDistricts(Set<AdDistrict> adDistricts) {
		this.adDistricts = adDistricts;
	}

}
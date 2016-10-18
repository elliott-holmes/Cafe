package holmes.elliott.cafe.model;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * @author holmese
 * Menu Item to show available products for sale.
 *
 */
public class MenuItem implements Serializable {

	private static final long serialVersionUID = 5141457272935709431L;
	private String productDescription;
	private BigDecimal productPrice;
	
	public MenuItem(){
		
	}

	public MenuItem(String productDescription, BigDecimal productPrice) {
		super();
		this.productDescription = productDescription;
		this.productPrice = productPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}

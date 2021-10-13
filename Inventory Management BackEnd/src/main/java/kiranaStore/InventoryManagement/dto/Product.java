package kiranaStore.InventoryManagement.dto;

public class Product {
	private Integer productId;
	private String productName;
	private Integer productPrice;
	private Integer productAvailability;
	public Product(){}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductAvailability() {
		return productAvailability;
	}
	public void setProductAvailability(Integer productAvailability) {
		this.productAvailability = productAvailability;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productAvailability=" + productAvailability + "]";
	}
}

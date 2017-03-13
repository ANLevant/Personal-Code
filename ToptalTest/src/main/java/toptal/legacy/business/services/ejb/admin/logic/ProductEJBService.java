package toptal.legacy.business.services.ejb.admin.logic;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import toptal.common.business.dto.ProductDTO;
import toptal.common.business.persistence.facade.entities.Product;
import toptal.common.business.persistence.facade.entities.ProductByUser;
import toptal.common.util.Constants;
import toptal.common.util.PropertyAcces;
import toptal.legacy.business.persistence.sql.entities.ProductByUserSQL;
import toptal.legacy.business.persistence.sql.entities.ProductSQL;
import toptal.legacy.business.services.ejb.admin.facade.ProductLocalService;
import toptal.spring.business.persistence.nosql.dao.ProductByUserNoSQLDAO;
import toptal.spring.business.persistence.nosql.dao.ProductNoSQLDAO;

@Stateless
public class ProductEJBService implements ProductLocalService {

	@EJB
	private ProductNoSQLDAO productDAO;
	
	@EJB
	private ProductByUserNoSQLDAO productByUserDAO;
	
	@Override
	public List<ProductDTO> getCustomerProducts(long customerId) {
		try
		{
			PropertyAcces propertyAcces = new PropertyAcces();
			
			URL url = new URL(propertyAcces.getProperty(Constants.URLS_PROPERTY_FILE_NAME, Constants.USD_CHANGE_RATE_NAME));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", MediaType.APPLICATION_XML);

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(url.openStream());
			
			NodeList nodeList = document.getElementsByTagName("Cube");
			
			float changeRateUSD = 0.0f;
			
			for(int i = 0; i < nodeList.getLength(); i++){
				Element element = (Element) nodeList.item(i);
				if(element.hasAttribute("currency") && element.getAttribute("currency").equals("USD")){
					changeRateUSD = Float.parseFloat(element.getAttribute("rate"));
					break;
				}
			}
			
			conn.disconnect();
			
			List<ProductByUser> productsByUser = productByUserDAO.getProductsByCustomer(customerId);
			
			List<ProductDTO> productsByCustomer = new ArrayList<ProductDTO>();
			
			for(ProductByUser productByUser : productsByUser){
				
				ProductDTO productDTO = new ProductDTO(productDAO.getProductById(productByUser.getProductByUserPK().getProductId()));
				
				productDTO.setPrice(productDTO.getPrice()*changeRateUSD);
				productDTO.setUsdChangeRate(changeRateUSD);
				
				productsByCustomer.add(productDTO);
				
			}
			
			return productsByCustomer;
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
			return null;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return null;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		} catch (SAXException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		
		List<Product> productList = productDAO.getAllProducts();
		
		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
		
		for(Product product: productList){
			productDTOList.add(new ProductDTO(product));
		}
		
		return productDTOList;
	}

	@Override
	public ProductDTO getProductById(long productId){
		
		return new ProductDTO(productDAO.getProductById(productId));
		
	}

}

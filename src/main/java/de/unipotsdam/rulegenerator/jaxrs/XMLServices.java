package de.unipotsdam.rulegenerator.jaxrs;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import de.unipotsdam.rulegenerator.jaxrs.services.ContextInformationService;
import de.unipotsdam.rulegenerator.jaxrs.services.RuleGeneratorService;
import de.unipotsdam.rulegenerator.rules.AdaptationRuleList;

// TODO: Auto-generated Javadoc
/**
 * The Class XMLServices.
 */
@Path("/xml")
public class XMLServices extends Services implements ErrorListener,
		ErrorHandler {

	/**
	 * Adaptation rule xml.
	 * 
	 * @return the adaptation rule list
	 * @throws Exception
	 */
	@POST
	@Path("/get-adaptation-rules")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_XML)
	public AdaptationRuleList getAdaptationRules(@FormParam("ontologyABox") String aBox, @FormParam("ontologyId") String ontologyId) {
		try {
			return RuleGeneratorService.generateAdaptationRules(aBox, ontologyId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the context information.
	 *
	 * @return the context information
	 */
	@GET
	@Path("/get-context-information")
	@Produces(MediaType.TEXT_XML)
	public String getContextInformation() {
		try {
			return ContextInformationService.getContextInformation();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void error(SAXParseException arg0) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatalError(SAXParseException arg0) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warning(SAXParseException arg0) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void error(TransformerException arg0) throws TransformerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fatalError(TransformerException arg0)
			throws TransformerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void warning(TransformerException arg0) throws TransformerException {
		// TODO Auto-generated method stub
		
	}
}

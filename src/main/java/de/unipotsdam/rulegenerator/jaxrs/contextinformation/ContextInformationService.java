package de.unipotsdam.rulegenerator.jaxrs.contextinformation;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.unipotsdam.rulegenerator.objects.ContextInformationList;

// TODO: Auto-generated Javadoc
/**
 * The Class ContextInformation.
 */
public class ContextInformationService {

	/**
	 * Gets the context informations.
	 * 
	 * @return the context informations
	 * @throws JsonParseException
	 *             the json parse exception
	 * @throws JsonMappingException
	 *             the json mapping exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	protected ContextInformationList getContextInformations()
			throws JsonParseException, JsonMappingException, IOException {
		ContextInformationList informations = new ContextInformationList();

		ObjectMapper mapper = new ObjectMapper();
		informations = mapper.readValue(new File(
				"resources/ContextInformation.json"),
				ContextInformationList.class);

		return informations;
	}
}

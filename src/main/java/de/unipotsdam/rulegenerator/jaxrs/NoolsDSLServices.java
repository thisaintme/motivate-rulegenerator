package de.unipotsdam.rulegenerator.jaxrs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Scanner;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import de.unipotsdam.rulegenerator.jaxrs.services.RuleGeneratorService;
import de.unipotsdam.rulegenerator.rules.AdaptationRuleList;

@Path("/noolsdsl")
public class NoolsDSLServices extends Services implements ErrorListener,
		ErrorHandler {

	@POST
	@Path("/get-adaptation-rules")
	@Consumes("application/x-www-form-urlencoded")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAdaptationRules(@FormParam("ontologyABox") String aBox,
			@FormParam("ontologyId") String ontologyId)
			throws TransformerFactoryConfigurationError,
			ParserConfigurationException, SAXException, TransformerException,
			IOException {
		// generate rules
		AdaptationRuleList adaptationRuleList;
		try {
			adaptationRuleList = RuleGeneratorService.generateAdaptationRules(
					aBox, ontologyId);
		} catch (Exception e) {
			return e.getClass() + " " + e.getMessage() + "\n\n"
					+ this.stackTraceToString(e);
		}

		String xml = RuleGeneratorService.XMLFromAdaptationRules(adaptationRuleList);

		String xslt = new Scanner(new File("./resources/noolsDSL.xslt"))
				.useDelimiter("\\Z").next();

		System.setProperty("javax.xml.transform.TransformerFactory",
				"net.sf.saxon.TransformerFactoryImpl");

		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		SAXParser parser = parserFactory.newSAXParser();
		parser.getXMLReader().setErrorHandler(this);
		SAXSource xmlInput = new SAXSource(parser.getXMLReader(),
				new InputSource(new StringReader(xml)));

		StringWriter stringWriter = new StringWriter();
		StreamResult xmlOutput = new StreamResult(stringWriter);
		TransformerFactory transformerFactory = TransformerFactory
				.newInstance();

		StreamSource source = new StreamSource(new StringReader(xslt));
		Transformer transformer = transformerFactory.newTransformer(source);
		transformer.setErrorListener(this);
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.transform(xmlInput, xmlOutput);

		OutputStreamWriter outputWriter = new OutputStreamWriter(
				new FileOutputStream("./resources/noolsDSLOutput.nools"),
				"UTF-8");
		outputWriter.write(xmlOutput.getWriter().toString());
		outputWriter.close();

		return xmlOutput.getWriter().toString();
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
}

package et.aqa.uima.annotator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import et.aqa.uima.AmharicDate;

public class AmharicDateAnnotator extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		String txt = aJCas.getDocumentText();
		// match ነሀሴ 21.2001, ......
		String patt = "(\\b((ነ[ሀሃሐሓኻ][ሴሤ])|(መ[ሥስ]ከረም)|ጥቅምት|([ህኅሕኽ]ዳር)|(ታህ[ሳሣ][ስሥ])|"
				+ "([ጠጥ]ር)|(የካቲት)|(መጋቢት)|(ሚያዚያ)|(ግንቦት)|([ሰሠ]ኔ)|([ሀሃሐሓኻ]ምሌ))\\b"
				+ "\\s*([1-9]|0[1-9]|1[0-9]|2[0-9]|30)\\s*\\b(ቀን)\\b"
				+ "(\\s)*([,/.፣])*(\\s)*((19|20)\\d\\d))|"
				+ "(\\b((ነ[ሀሃሐሓኻ][ሴሤ])|(መ[ሥስ]ከረም)|ጥቅምት|([ህኅሕኽ]ዳር)|(ታህ[ሳሣ][ስሥ])|"
				+ "([ጠጥ]ር)|(የካቲት)|(መጋቢት)|(ሚያዚያ)|(ግንቦት)|([ሰሠ]ኔ)|([ሀሃሐሓኻ]ምሌ))\\b"
				+ "\\s*([1-9]|0[1-9]|1[0-9]|2[0-9]|30)"
				+ "(\\s)*([/,.፣])*(\\s)*((19|20)\\d\\d))|"
				+ "(ነሀሴ|መስከረም|ጥቅምት|ህዳር|ታህሳስ|"
				+ "[ጠጥ]ር|የካቲት|መጋቢት|ሚያዚያ|ግንቦት|ሰኔ|ሀምሌ)(\\s*)(\\d)*"
				+ "(\\s*)(ሰኞ|ማክሰኞ|ረብኡ|ቀን|ሀሙስ|ቅዳሜ|እሁድ|አርብ)*\\s*(([1-9][0-9])\\d\\d)*";
		// match 01/02/2009, 10-10-1998......
		String patt2 = "(((0[1-9]|[12][0-9]|30)|(0[1-9]|1[0123]))[-/.፣]" +
				"((0[1-9]|[12][0-9]|30)|(0[1-9]|1[0123]))[-/.፣]"
				+ "(19|20)\\d\\d)";// to match date like 01/01/2007-sample
									// ......
		// to match date like 1998-1999, 1900/1901, 2001,2002......
		String patt3 = "\\b((19|20)\\d\\d)\\b(\\s)*([,/.-፣])*(\\s)*\\b((19|20)\\d\\d)\\b";
		// to match ዘንድሮ, በሚቀጥለው አመት, በ1991 ......
		String patt4 = "((ዛሬ|ዘንድሮ|ትናንት|ሰኞ|ማክሰኞ|ረብኡ|ሀሙስ|ቅዳሜ|እሁድ|አርብ|እለት)\\s*|"
				+ "([በለከየ])((([0-9][0-9])\\d\\d)|\\d+)+\\s*|[ከበለየ]*(አንድ|ሁለት|ሶስት|አራት|\\d*|አምስት|"
				+ "ስድስት|ሰባት|ስምንት|ዘጠኝ|ባለፈው|ሚቀጥለው|መጭው)+\\s*"
				+ "(አመት|አመታት|ሳምንት|ሳምንታት|ወር|ቀን|ቀናት|ሰአት|ደቂቃ|ሰከንድ"
				+ "|ወራት|ሰአታት|ሰኞ|ማክሰኞ|ረብኡ|ሀሙስ|ቅዳሜ|እሁድ|አርብ)\\s*"
				+ "(በፊት|በኋላ)*\\s*|([ከበለ]*አንድ|ሁለት|ሶስት|አራት|አምስት|"
				+ "ስድስት|ሰባት|ስምንት|ዘጠኝ|አስር|አስራ)+\\s*"
				+ "(ዓመት|ዓመታት|አመት|አመታት|ሳምንት|ሳምንታት|ወር|ደቂቃ|ሰከንድ|ቀን|ቀናት|ሰአት|ወራት|ሰአታት)\\s*)+";
		Pattern regPat = Pattern.compile(patt);
		// Pattern regPat1 = Pattern.compile(patt1);
		Pattern regPat2 = Pattern.compile(patt2);
		Pattern regPat3 = Pattern.compile(patt3);
		Pattern regPat4 = Pattern.compile(patt4);

		Matcher matcher = regPat.matcher(txt);
		Matcher matcher2 = regPat2.matcher(txt);
		Matcher matcher3 = regPat3.matcher(txt);
		Matcher matcher4 = regPat4.matcher(txt);

		Boolean m = matcher.find(), m2 = matcher2.find(), m3 = matcher3.find(), m4 = matcher4
				.find();
		while (m || m2 || m3 || m4) {

			AmharicDate amharicDateAnnotation = new AmharicDate(aJCas);
			if(m){
				amharicDateAnnotation.setDate("EthiopianDate");
				amharicDateAnnotation.setBegin(matcher.start());
				amharicDateAnnotation.setEnd(matcher.end());
				amharicDateAnnotation.addToIndexes();
				m = matcher.find();
			}
			if (m2){
				amharicDateAnnotation = new AmharicDate(aJCas);
				amharicDateAnnotation.setDate("GlobalDate");
				amharicDateAnnotation.setBegin(matcher2.start());
				amharicDateAnnotation.setEnd(matcher2.end());

				amharicDateAnnotation.addToIndexes();
				
				m2 = matcher2.find();
			}
			if(m3){
				amharicDateAnnotation = new AmharicDate(aJCas);
				amharicDateAnnotation.setDate("RangeDate");
				amharicDateAnnotation.setBegin(matcher3.start());
				amharicDateAnnotation.setEnd(matcher3.end());

				amharicDateAnnotation.addToIndexes();
				m3 = matcher3.find();
			}
			if(m4){
				amharicDateAnnotation = new AmharicDate(aJCas);
				amharicDateAnnotation.setDate("EthiopicWordDate");
				amharicDateAnnotation.setBegin(matcher4.start());
				amharicDateAnnotation.setEnd(matcher4.end());

				amharicDateAnnotation.addToIndexes();
				m4 = matcher4.find();
			}
		}
	}

}

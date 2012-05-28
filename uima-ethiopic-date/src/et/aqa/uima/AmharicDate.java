

/* First created by JCasGen Mon May 28 11:37:57 CEST 2012 */
package et.aqa.uima;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon May 28 11:37:57 CEST 2012
 * XML source: /home/seidm/android/uimaj-examples/descriptors/AmharicDateAnnotatorAEDescriptor.xml
 * @generated */
public class AmharicDate extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(AmharicDate.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected AmharicDate() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public AmharicDate(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public AmharicDate(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public AmharicDate(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: Date

  /** getter for Date - gets 
   * @generated */
  public String getDate() {
    if (AmharicDate_Type.featOkTst && ((AmharicDate_Type)jcasType).casFeat_Date == null)
      jcasType.jcas.throwFeatMissing("Date", "et.aqa.uima.AmharicDate");
    return jcasType.ll_cas.ll_getStringValue(addr, ((AmharicDate_Type)jcasType).casFeatCode_Date);}
    
  /** setter for Date - sets  
   * @generated */
  public void setDate(String v) {
    if (AmharicDate_Type.featOkTst && ((AmharicDate_Type)jcasType).casFeat_Date == null)
      jcasType.jcas.throwFeatMissing("Date", "et.aqa.uima.AmharicDate");
    jcasType.ll_cas.ll_setStringValue(addr, ((AmharicDate_Type)jcasType).casFeatCode_Date, v);}    
  }

    
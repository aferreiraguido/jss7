package org.mobicents.protocols.ss7.tcap.asn;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.mobicents.protocols.asn.AsnInputStream;
import org.mobicents.protocols.ss7.tcap.asn.comp.Component;
import org.mobicents.protocols.ss7.tcap.asn.comp.ComponentType;

import junit.framework.TestCase;

/**
 * 
 * @author amit bhayani
 *
 */
public class ReturnResultLastTest extends TestCase {
	
	@org.junit.Test
	public void testDecodeWithParaSequ() throws IOException, ParseException {
		
		
		/**
		 * TODO :
		 * This test is half, as the ReturnResultLastImpl and ReturnResultImpl still has ambiguity in decode(). Read comments in  respective 
		 * classes .decode method 
		 */
		
		
		byte[] b = new byte[] { 
				(byte) 0xa2, //ReturnResultLast Tag
				
				0x3b, //Length Dec 59 
				
				0x02, 0x01, (byte)0x80, //Invoke ID TAG(2) Length(1) Value(12) 
				
				0x30, 0x36, //Sequence of Operation Code and Parameter 
				
						0x02, 0x01, 0x3b, //Operation Code TAG(2), Length(1), Value(59)
				
						//Sequence of parameter 
						0x30, 0x31, 
				
						//Parameter 1
						0x04, 0x01, 0x0f, 
				
						//Parameter 2
						0x04, 0x2c,  (byte)0xd9, 0x77, 0x1d, 0x44, 0x7e, (byte)0xbb, 0x41, 0x74, 0x10, 0x3a, 0x6c, 0x2f, (byte)0x83, (byte)0xca, (byte)0xee, 0x77,
						(byte)0xfd, (byte)0x8c, 0x06, (byte)0x8d, (byte)0xe5, 0x65, 0x72, (byte)0x9a, 0x0e, (byte)0xa2, (byte)0xbf, 0x41, (byte)0xe3, 0x30, (byte)0x9b, 0x0d,
						(byte)0xa2, (byte)0xa3, (byte)0xd3, 0x73, (byte)0x90, (byte)0xbb, (byte)0xde, 0x16, (byte)0x97, (byte)0xe5, 0x2e, 0x10 };
		
		AsnInputStream asnIs = new AsnInputStream(new ByteArrayInputStream(b));

		Component comp = TcapFactory.createComponent(asnIs);

		assertEquals(ComponentType.Invoke, comp.getType());
		
	}

}

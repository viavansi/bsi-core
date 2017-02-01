package iso;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import eu.inn.biometric.signature.device.CapturingComponent;
import eu.inn.biometric.signature.device.Dimension;
import eu.inn.biometric.signature.device.Point;
import eu.inn.biometric.signature.device.SignArea;
import eu.inn.biometric.signature.managed.ManagedIsoPoint;
import eu.inn.biometric.signature.managed.impl.IsoSignatureData;


public class ISOTest {
    @Test
    public void testSChannel() throws Exception
    {
        List<ManagedIsoPoint> isoPointList=new ArrayList<ManagedIsoPoint>();
        for(int i=0;i!=50;i++)
        {
            int s=1;
            if((i>0 && i<20)||(i>30))
            {
                s=0;
                
            }
            double a=(360.0*i)/50.0;
            double e=(360.0*i)/50.0;
            double r=(360.0*i)/50.0;
            ManagedIsoPoint isoPoint=new ManagedIsoPoint(i, i, s,1, a, e, r);
            isoPointList.add(isoPoint);
        }
        
        CapturingComponent capturingComponent=new CapturingComponent();
        capturingComponent.setAzimuthSupported(true);
        capturingComponent.setRotationSupported(true);
        capturingComponent.getPressure().setAirmovesSupported(true);
        capturingComponent.setSignArea(new SignArea(new Point(0,0), new Dimension(1000, 1000)));
        
        IsoSignatureData iso = IsoSignatureData.fromData(isoPointList, capturingComponent);
        byte isoBytes[]=iso.getIsoData();
        
        iso = IsoSignatureData.fromIso(isoBytes);
        CapturingComponent componentInfo = iso.getCapturingComponent();
        List<ManagedIsoPoint> points = iso.getIsoPoints();
        
        
        System.out.println("Finished");
    }
}

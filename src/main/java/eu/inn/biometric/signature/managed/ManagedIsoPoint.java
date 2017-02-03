package eu.inn.biometric.signature.managed;

/*
 * #%L
 * BioSignIn (Biometric Signature Interface) Core [http://www.biosignin.org]
 * ManagedIsoPoint.java is part of BioSignIn project
 * %%
 * Copyright (C) 2014 Innovery SpA
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */




import eu.inn.biometric.signature.isoiec19794.y2007.Channel;
import eu.inn.biometric.signature.isoiec19794.y2007.IsoPoint;

public class ManagedIsoPoint {

	private long time = System.currentTimeMillis();
	private int pressure;
	private double x;
	private double y;
	private double s;
	private double penAzimuth;
	private double penElevation;
	private double penRotation;
	
	
	@Override
	public ManagedIsoPoint clone() throws CloneNotSupportedException {
		return (ManagedIsoPoint)super.clone();
	}
	public int getPressure() {
		return pressure;
	}

	/*
	public ManagedIsoPoint(double x, double y, int s) {
		this(x, y, s, 0);
	}

	public ManagedIsoPoint(double x, double y, int s, int pressure) {
		this.setX(x);
		this.setY(y);
		this.setS(s);
		this.pressure = pressure;
	}
    */
	
	public ManagedIsoPoint(double x, double y, double s, int pressure,double penAzimuth,double penElevation,double penRotation) {
        this.setX(x);
        this.setY(y);
        this.setS(s);
        this.pressure = pressure;
        this.penAzimuth=penAzimuth;
        this.penElevation=penElevation;
        this.penRotation=penRotation;
    }

	
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public static ManagedIsoPoint fromIsoPoint(IsoPoint p) {
		int time = p.getProperty(Channel.T);
		int x = p.getProperty(Channel.X);
		int y = p.getProperty(Channel.Y);
		
		int s=0;
		if(p.getProperty(Channel.S)!=null)
		{
		    s = p.getProperty(Channel.S);
		}		
		
		int penAzimuth=0;
		if(p.getProperty(Channel.AZ)!=null)
		{
		    penAzimuth=p.getProperty(Channel.AZ);
		}
		
		int penElevation=0;
		if(p.getProperty(Channel.EL)!=null)
		{
		    penElevation=p.getProperty(Channel.EL);
		}		
		int penRotation=0;
		if(p.getProperty(Channel.R)!=null)
		{
		    penRotation=p.getProperty(Channel.R);
		}
		int pressure = 0;
		if(p.getProperty(Channel.F)!=null)
        {
            pressure=p.getProperty(Channel.F);
        }
		ManagedIsoPoint ret = new ManagedIsoPoint(x, y, s, pressure,penAzimuth,penElevation,penRotation);
		ret.setTime(time);
		return ret;
	}

	public void setX(java.lang.Double x) {

		this.x = x.intValue();
	}

	public void setY(java.lang.Double y) {
		this.y = y.intValue();
	}

	public double getX() {
		return x;
	}
	public int getXAsInt() {
		return (int)Math.round(x);
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}
	public int getYAsInt() {
		return (int)Math.round(y);
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
    /**
     * @return the s
     */
    public double getS() {
        return s;
    }
    /**
     * @param s the s to set
     */
    public void setS(double s) {
        this.s = s;
    }
    /**
     * @return the penAzimuth
     */
    public double getPenAzimuth() {
        return penAzimuth;
    }
    /**
     * @param penAzimuth the penAzimuth to set
     */
    public void setPenAzimuth(double penAzimuth) {
        this.penAzimuth = penAzimuth;
    }
    /**
     * @return the penElevation
     */
    public double getPenElevation() {
        return penElevation;
    }
    /**
     * @param penElevation the penElevation to set
     */
    public void setPenElevation(double penElevation) {
        this.penElevation = penElevation;
    }
    /**
     * @return the penRotation
     */
    public double getPenRotation() {
        return penRotation;
    }
    /**
     * @param penRotation the penRotation to set
     */
    public void setPenRotation(double penRotation) {
        this.penRotation = penRotation;
    }
    

}
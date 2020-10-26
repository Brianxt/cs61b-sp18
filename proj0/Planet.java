/** Proj0 */
public class Planet {
	private static final double G = 6.67e-11;
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public Planet(double xP, double yP, double xV,
		      double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}
	public double calcDistance(Planet p){
		double r = Math.sqrt((this.xxPos - p.xxPos)*(this.xxPos - p.xxPos) + 
				(this.yyPos - p.yyPos)*(this.yyPos - p.yyPos));
		return r;
	}
	public double calcForceExertedBy(Planet p){
		double r = this.calcDistance(p);
		double F = (G * this.mass * p.mass)/(r * r);
		return F;
	}
	public double calcForceExertedByX(Planet p){
		double r = this.calcDistance(p);
		double F = this.calcForceExertedBy(p);
		double dx = p.xxPos - this.xxPos;
		double Fx = (F * dx)/r;
		return Fx;
	}
	public double calcForceExertedByY(Planet p){
                double r = this.calcDistance(p);
                double F = this.calcForceExertedBy(p);
                double dy = p.yyPos - this.yyPos;
                double Fy = (F * dy)/r;
                return Fy;
        }
	public double calcNetForceExertedByX(Planet[] allPlanets){
		double NetFx = 0;
		for ( int i = 0; i < allPlanets.length; i += 1){
			if(this.equals(allPlanets[i])){
				continue;
			}
			else{
				NetFx = NetFx + this.calcForceExertedByX(allPlanets[i]);
			}
		}
		return NetFx;
	}
	public double calcNetForceExertedByY(Planet[] allPlanets){
                double NetFy = 0;
		for ( int i = 0; i < allPlanets.length; i += 1){
                        if(this.equals(allPlanets[i])){
                                continue;
                        }
                        else{
                                NetFy = NetFy + this.calcForceExertedByY(allPlanets[i]);
                        }
                }
                return NetFy;
        }
	public void update(double dt,double fX,double fY){
		double aX, aY;
		aX = fX / this.mass;
		aY = fY / this.mass;
		this.xxVel = this.xxVel + dt * aX;
		this.yyVel = this.yyVel + dt * aY;
		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}
	public void draw(){
		StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
	}
}


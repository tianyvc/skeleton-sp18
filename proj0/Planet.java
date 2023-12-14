public class Planet {
    
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, 
    double yV, double m, String img)
    {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p)
    {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p)
    {
        double dx = xxPos - p.xxPos;
        double dy = yyPos - p.yyPos;
        double dis = Math.sqrt(dx * dx + dy * dy);
        return dis;
    }
    public double calcForceExertedBy(Planet p)
    {
        double r = calcDistance(p);
        double f = G * mass * p.mass / (r * r);
        return f;
    }
    public double calcForceExertedByX(Planet p)
    {
        double dx = p.xxPos - xxPos;
        double r = calcDistance(p);
        return calcForceExertedBy(p) * dx / r;
    }
    public double calcForceExertedByY(Planet p)
    {
        double dy = p.yyPos - yyPos;
        double r = calcDistance(p);
        return calcForceExertedBy(p) * dy / r;
    }
    public double calcNetForceExertedByX(Planet[] allPlanets)
    {
        double totForceX = 0;
        for(Planet p : allPlanets)
        {
            if(this.equals(p))
            {
                continue;
            }
            totForceX += calcForceExertedByX(p);
        }
        return totForceX;
    }
    public double calcNetForceExertedByY(Planet[] allPlanets)
    {
        double totForceY = 0;
        for(Planet p : allPlanets)
        {
            if(this.equals(p))
            {
                continue;
            }
            totForceY += calcForceExertedByY(p);
        }
        return totForceY;
    }
    public void update(double dt, double fX, double fY)
    {
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel += aX * dt;
        yyVel += aY * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }
    public void draw()
    {
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
	}
}
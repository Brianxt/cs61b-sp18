public class NBody{
	public static double readRadius(String path){
		In in = new In(path);
		int N = in.readInt();
		double Radius = in.readDouble();
		return Radius;
	}
	public static Planet[] readPlanets(String path){ 
		In in = new In(path);
		int N = in.readInt();
		Planet[] p = new Planet[N];
		double Radius = in.readDouble();
		for(int i = 0; i < N; i += 1){
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			p[i] = new Planet(xP, yP, xV, yV, m, img);
		}
		return p;
	}
	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double Radius = readRadius(filename);
		Planet[] allPlanets = readPlanets(filename);
		String imageToDraw = "D:/cs61b-sp18/cs61b-sp18/proj0/images/starfield.jpg";
		String MusicToPlay = "D:/cs61b-sp18/cs61b-sp18/proj0/audio/2001.mid";
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(- Radius, Radius);
		StdDraw.clear();
		StdAudio.play(MusicToPlay);
		double t = 0;
		int n = allPlanets.length;
		while(t < T){
			double[] xForces = new double[n];
			double[] yForces = new double[n];
			for (int i = 0; i < n; i += 1){
				xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
				yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
			}
			StdDraw.picture(0, 0, imageToDraw);
			for (int i = 0; i < n; i += 1){
			        allPlanets[i].update(dt, xForces[i], yForces[i]);
				allPlanets[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			t = t + dt;
		}
		StdOut.printf("%d\n", n);
		StdOut.printf("%.2e\n", Radius);
		for (int i = 0; i < n; i++) {
    			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                  allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);
		}
	}
}

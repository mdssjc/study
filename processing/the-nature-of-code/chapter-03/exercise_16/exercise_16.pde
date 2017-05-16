Bob bob[];
Spring spring[];

void setup() {
  size(640, 360);
  bob = new Bob[1];
  spring = new Spring[2];

  bob[0] = new Bob(width/2, 100);
  spring[0] = new Spring(width/2, 10, 100);
  spring[1] = new Spring(width/2+50, 10, 100);
}

void draw() {
  background(255); 

  PVector gravity = new PVector(0, 2);
  for (int i = 0; i < bob.length; i++) {
    bob[i].applyForce(gravity);
  }

  spring[0].connect(bob[0]);
  spring[0].constrainLength(bob[0], 30, 200);

  spring[1].connect(bob[0]);
  spring[1].constrainLength(bob[0], 30, 200);

  bob[0].update();
  spring[0].displayLine(bob[0]); 
  spring[1].displayLine(bob[0]); 
  bob[0].display(); 
  spring[0].display(); 
  spring[1].display(); 

  fill(0);
}
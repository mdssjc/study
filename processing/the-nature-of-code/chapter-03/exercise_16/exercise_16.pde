Bob bob[];
Spring spring[];

void setup() {
  size(640, 360);
  bob = new Bob[3];
  spring = new Spring[3];

  bob[0] = new Bob(width/2, 50);
  bob[1] = new Bob(width*0.2, 400);
  bob[2] = new Bob(width*0.8, 200);

  spring[0] = new Spring(bob[0], 100);
  spring[1] = new Spring(bob[1], 100);
  spring[2] = new Spring(bob[2], 100);
}

void draw() {
  background(255); 

  spring[0].connect(bob[1]);
  spring[0].constrainLength(bob[0], 30, 200);

  spring[1].connect(bob[2]);
  spring[1].constrainLength(bob[2], 30, 200);

  spring[2].connect(bob[0]);
  spring[2].constrainLength(bob[0], 30, 200);

  bob[0].update();
  bob[1].update();
  bob[2].update();
  spring[0].displayLine(bob[1]); 
  spring[1].displayLine(bob[2]);
  spring[2].displayLine(bob[0]);
  bob[0].display(); 
  bob[1].display(); 
  bob[2].display(); 
  spring[0].display(); 
  spring[1].display(); 
  spring[2].display();
}
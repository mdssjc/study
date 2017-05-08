Pendulum p[];

void setup() {
  size(640, 360);

  p = new Pendulum[5];
  for (int i = 0; i < p.length; i++) {
    p[i] = new Pendulum(new PVector(width/2, 10), random(20, 90));
  }
}

void draw() {
  background(255);

  PVector location = new PVector(0, 0);
  for (int i = 0; i < p.length; i++) {
    if (i == 0) {
      p[i].go();
    } else {
      location.y += 8;
      p[i].setOrigin(location);
      p[i].go();
    }
    location = p[i].getlocation();
  }
}
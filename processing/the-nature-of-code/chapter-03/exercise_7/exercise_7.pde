Oscillator[] oscillators = new Oscillator[10];

void setup() {
  size(640, 360);

  for (int i = 0; i < oscillators.length; i++) {
    oscillators[i] = new Oscillator(.002*(i+1), .02*(i+1), 100, 10);
  }
}

void draw() {
  background(255);

  for (int i = 0; i < oscillators.length; i++) {
    oscillators[i].oscillate();
    oscillators[i].display();
  }
}
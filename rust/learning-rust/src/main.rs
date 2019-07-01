fn main() {
    println!("Hello, world!");

    let x = 2;
    let square = |x: i32| -> i32 {
        x * x
    };
    println!("{}", square(x));
}

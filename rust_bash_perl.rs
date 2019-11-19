use std::process::Command;

fn main() {
    Command::new("perl")
        .arg("-e")
        .arg("print 'hello';")
        .spawn()
        .expect("hello");
}

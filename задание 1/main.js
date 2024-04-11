const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question("Input length: ", function(N) {
    rl.question("Input width: ", function(M) {
        rl.question("Input all commands: ", function(commands) {
            let x = 0, y = 0;

            for (let i = 0; i < commands.length; i++) {
                const command = commands[i];
                if (command === 'L') {
                    x -= 1;
                } else if (command === 'R') {
                    x += 1;
                } else if (command === 'D') {
                    y += 1;
                } else if (command === 'U') {
                    y -= 1;
                } else {
                    console.log("Invalid command - " + command);
                    return;
                }

                if (Math.abs(y) >= N || Math.abs(x) >= M) {
                    console.log("No");
                    return;
                }
            }

            console.log("(" + (M - Math.abs(x)) + "," + (N - Math.abs(y)) + ")");
            rl.close();
        });
    });
});

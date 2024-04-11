print "Input length: "
N = gets.chomp.to_i

print "Input width: "
M = gets.chomp.to_i

print "Input all commands: "
commands = gets.chomp

x = 0
y = 0

commands.each_char do |command|
    case command
    when 'L'
        x -= 1
    when 'R'
        x += 1
    when 'D'
        y += 1
    when 'U'
        y -= 1
    else
        raise ArgumentError, "Invalid command - #{command}"
    end

    if y.abs >= N || x.abs >= M
        puts "No"
        exit 1
    end
end

puts "(#{M - x.abs}, #{N - y.abs})"

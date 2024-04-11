def init_list():
    while True:
        try:
            nums = list(map(int, input("Enter the numbers separated by a space: ").split()))
            return nums
        except ValueError:
            print("Error: An invalid value has been entered! Try again: ")


def is_prime(num):
    if num <= 1:
        return False
    
    for i in range(2, int(num**0.5) + 1):
        if num % i == 0:
            return False
        
    return True


def main():
    numbers = init_list()

    prime_count = sum(1 for num in numbers if is_prime(num))

    print("Number of prime numbers:", prime_count)




if __name__ == "__main__":
    main()

import argparse
import random
import sys

def parse_input_range(input_range):
    pos = input_range.find('-')
    if pos < 0:
        raise RuntimeError('no "-" found in input-range')

    lo = int(input_range[:pos])
    hi = int(input_range[pos+1:])

    return lo, hi

def generate_from_list(file=None, input_range=None):
    if not file and not input_range:
        raise RuntimeError("file and input_range are both None")

    if file:
        return [line.strip() for line in file.readlines()]
    else:
        lo, hi = parse_input_range(input_range)
        return [str(a) for a in range(lo, hi+1)]

def shuf(from_list, head_count, repeat):
    if head_count: # -n is a real number
        if repeat: # -r can repeat
            for _ in range(head_count):
                print(random.choice(from_list))
        else: # do not repeat
            l = min(head_count, len(from_list))
            print('\n'.join(random.sample(from_list, l)))
    else: # -n is None
        if repeat: # -r can repeat - endless loop
            while True:
                print(random.choice(from_list))
        else: # do not repeat - shuffle
            random.shuffle(from_list)
            print('\n'.join(from_list))

if __name__ == '__main__':
    # sample usage:
    # python3 shuf3.py -n 50 -i 0-9 -r
    # python3 shuf3.py -n 50 -i 0-9
    # python3 shuf3.py -n 5 -i 0-9 -r
    # python3 shuf3.py -n 5 -i 0-9
    # python3 shuf3.py -i 0-9 -r
    # python3 shuf3.py -i 0-9
    # python3 shuf3.py -n 10 -r aaa
    # python3 shuf3.py -n 10 aaa
    # python3 shuf3.py -n 2 
    # python3 shuf3.py -n 2 -

    parser = argparse.ArgumentParser()
    parser.add_argument("-i", "--input-range", dest="input_range", help="treat each number LO through HI as an input "
                                                                        "line")
    parser.add_argument("-n", "--head-count", dest="head_count", type=int, help="output at most COUNT lines")
    parser.add_argument("-r", "--repeat", dest="repeat", action="store_true", help="output lines can be repeated")
    parser.add_argument('optional', nargs='?', default=None)
    args = parser.parse_args()

    # if args.optional == "-" or args.optional == None:
    # else:
    #     from_list = generate_from_list(open(file=args.optional), input_range=None)

    if args.input_range:
        from_list = generate_from_list(file=None, input_range=args.input_range)
    else:
        if args.optional == None or args.optional == '-':
            from_list = generate_from_list(sys.stdin, input_range=None)
        else:
            from_list = generate_from_list(open(args.optional), input_range=None)

    shuf(from_list, args.head_count, args.repeat)

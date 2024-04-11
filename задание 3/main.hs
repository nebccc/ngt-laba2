import Control.Monad (replicateM)
import Data.List (genericLength)
import System.IO (isEOF)

isPrime :: Int -> Bool
isPrime num
    | num <= 1 = False
    | otherwise = all (\i -> num `mod` i /= 0) [2..limit]
    where limit = floor $ sqrt $ fromIntegral num

main :: IO ()
main = do
    putStrLn "Enter the number of integers:"
    input <- getLine
    let size = read input :: Int
    putStrLn "Enter the integers:"
    nums <- replicateM size readLn
    let res = genericLength $ filter isPrime nums
    print res
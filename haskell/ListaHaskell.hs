ex1 :: Integer -> IO()
ex1 0 = print 0 
ex1 n = print (n*365)

ex2 :: Float -> IO()
ex2 x = do 
    let y = (x / 937)
    let z = (x / 3.12)
    putStrLn ("Salarios minimos: " ++ show y)
    putStrLn ("Dolares: " ++ show z)

ex3:: Integer -> Integer -> Integer -> IO()
ex3 x y z = if (y+z==x) then putStrLn (show x ++ " e soma de " ++ show y ++" e "++ show z)
            else putStrLn (show x ++ " nao e a soma de " ++ show y++" e "++show z)


ex4 :: [a] -> [a] 
ex4 list = myflip list [] 
       where myflip list newList = if null list then newList
                                   else myflip (tail list) ((head list):newList)

ex5 :: Integer -> [Integer]
ex5 n = [e | e <- [1..n], e `mod` 3 == 1]


ex6 :: Integer -> Integer -> Integer -> [Integer]
ex6 x y z = [e | e <- [x, x+y..z] ]



ex7 :: Integer -> Integer
ex7 0 = 1
ex7 n = ex7(n-1)*n


ex8 :: Integer -> Integer
ex8 1 = 1
ex8 2 = 1
ex8 n = ex8 (n-1) + ex8 (n-2)




ex9 :: Integer -> Integer -> IO()
ex9 x y = if (x>y) then putStrLn (show x ++ " e maior que " ++ show y)
          else if (x<y) then putStrLn (show y ++ " e maior que " ++ show x) 
               else putStrLn (show x ++ " e " ++ show y ++ " sao iguais")


divs :: Integer -> [Integer]
divs n = [e | e<-[1..n], n `mod` e == 0]

primo :: Integer -> Bool
primo n = divs n == [1, n]

primos :: Integer -> [Integer]
primos n = [e | e <- [2..n], primo e]

ex10 :: Integer -> Integer -> [Integer] -> [Integer]
ex10 conta n lista = if (n<2) then lista
        else if (primo conta) then ex10 (conta+1) (n-1) (lista ++ [conta])
             else ex10 (conta+1) n lista 
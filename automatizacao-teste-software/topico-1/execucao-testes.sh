# testes iniciais
echo "Testes Iniciais"
for file in $(ls ts-aa/*.tes)
do
    a=$(< $file)
    b=$(java -cp CommentPrinter.jar CommentPrinter < $file)
    echo "$a $b"
done

# variação 1: /
echo ""
echo "Variação 1: /"
for file in $(ls ts-aa/var1/*.tes)
do
    a=$(< $file)
    b=$(java -cp CommentPrinter.jar CommentPrinter < $file)
    echo "$a $b"
done

# variação 2: */
echo ""
echo "Variação 2: */"
for file in $(ls ts-aa/var2/*.tes)
do
    a=$(< $file)
    b=$(java -cp CommentPrinter.jar CommentPrinter < $file)
    echo "$a $b"
done

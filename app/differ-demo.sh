echo "//differ cmd application demo"
sleep 2
echo

echo "//starting app without parameters"
sleep 2
echo
echo ./build/install/app/bin/app
echo
./build/install/app/bin/app
sleep 3
echo
echo

echo "//printing help"
sleep 2
echo
echo ./build/install/app/bin/app --help
echo
./build/install/app/bin/app --help
sleep 3
echo
echo


echo "//comparing 2 json files with default formatter (stylish)"
sleep 2
echo
echo ./build/install/app/bin/app ./tmp/file1Nested.json ./tmp/file2Nested.json
echo
./build/install/app/bin/app ./tmp/file1Nested.json ./tmp/file2Nested.json
sleep 3
echo
echo


echo "//comparing 2 json files with explicitly defined formatter (stylish)"
sleep 2
echo
echo ./build/install/app/bin/app -f stylish ./tmp/file1Nested.json ./tmp/file2Nested.json
echo
./build/install/app/bin/app -f stylish ./tmp/file1Nested.json ./tmp/file2Nested.json
sleep 3
echo
echo


echo "//comparing 2 json files with explicitly defined formatter (plain)"
sleep 2
echo
echo ./build/install/app/bin/app -f plain ./tmp/file1Nested.json ./tmp/file2Nested.json
echo
./build/install/app/bin/app -f plain ./tmp/file1Nested.json ./tmp/file2Nested.json
sleep 3
echo
echo


echo "//comparing 2 json files with explicitly defined formatter (output formatted as json)"
sleep 2
echo
echo ./build/install/app/bin/app -f json ./tmp/file1Nested.json ./tmp/file2Nested.json
echo
./build/install/app/bin/app -f json ./tmp/file1Nested.json ./tmp/file2Nested.json
sleep 3
echo
echo


echo "//comparing 2 yaml files with explicitly defined formatter (stylish)"
sleep 2
echo
echo ./build/install/app/bin/app -f stylish ./tmp/file1Nested.yml ./tmp/file2Nested.yml
echo
./build/install/app/bin/app -f stylish ./tmp/file1Nested.yml ./tmp/file2Nested.yml
sleep 3
echo
echo


echo "//comparing 2 yaml files with explicitly defined formatter (plain)"
sleep 2
echo
echo ./build/install/app/bin/app -f plain ./tmp/file1Nested.yml ./tmp/file2Nested.yml
echo
./build/install/app/bin/app -f plain ./tmp/file1Nested.yml ./tmp/file2Nested.yml
sleep 3
echo
echo


echo "//comparing 2 yaml files with explicitly defined formatter (output formatted as json)"
sleep 2
echo
echo ./build/install/app/bin/app -f json ./tmp/file1Nested.yml ./tmp/file2Nested.yml
echo
./build/install/app/bin/app -f json ./tmp/file1Nested.yml ./tmp/file2Nested.yml
sleep 3
echo
echo

exit
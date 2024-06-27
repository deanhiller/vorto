#!/bin/bash

#remove the log file I use for debugging when the python runs
rm ~/server.log

DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd $DIR/../routingCars

#just clean the previously unzipped file not entire build as gradle does a good job at change detection
rm -rf app/build/distributions

./gradlew build

#!/bin/bash

# Run the gradle build command
./gradlew build

# Check if the command was successful
if [ $? -ne 0 ]; then
  echo "Build failed"
  exit 1
else
  echo "Build succeeded"
fi


cd app/build/distributions
unzip app.zip

cd $DIR

echo "pwd=$(pwd)"

ls ../routingCars/app/build/distributions/app/bin/app

python3 evaluateShared.py --cmd "../routingCars/app/build/distributions/app/bin/app" --problemDir trainingProblems

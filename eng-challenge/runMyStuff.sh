#!/bin/bash

DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd $DIR/../routingCars

#just clean the previously unzipped file not entire build as gradle does a good job at change detection
rm -rf app/build/distributions

./gradlew build

cd app/build/distributions
unzip app.zip

cd $DIR

echo "pwd=$(pwd)"

ls ../routingCars/app/build/distributions/app/bin/app

python3 evaluateShared.py --cmd "../routingCars/app/build/distributions/app/bin/app" --problemDir trainingProblems

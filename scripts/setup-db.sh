#!/bin/bash

# This script sets up the database for the Fleet Inventory Management application.

# Exit on error
set -e

# Database configuration
DB_NAME="fleet_inventory"
DB_USER="your_username"
DB_PASSWORD="your_password"
DB_HOST="localhost"
DB_PORT="5432"

# Create the database
echo "Creating database $DB_NAME..."
psql -h $DB_HOST -U $DB_USER -p $DB_PORT -c "CREATE DATABASE $DB_NAME;"

# Run the initial SQL migration
echo "Running database migration..."
psql -h $DB_HOST -U $DB_USER -d $DB_NAME -f ../src/main/resources/db/migration/V1__init.sql

echo "Database setup completed."
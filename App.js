import React, { useState } from "react";
import { Box, Typography, TextField, FormControlLabel, Checkbox, Button } from "@mui/material";
import axios from "axios";

function App() {

    const [city, setCity] = useState(null)
    const [numDays, setNumDays] = useState(1)
    const [locations, setLocations] = useState(null)
    const [includePrices, setIncludePrices] = useState(false);
    const [includeTransportation, setIncludeTransportation] = useState(false);
    const [minimizeTravel, setMinimizeTravel] = useState(false);
    const [itinerary, setItinerary] = useState(null);
    
    const generateItinerary = () => {

        const requestData = {
            city,
            numDays,
            locations,
            includePrices,
            includeTransportation,
            minimizeTravel
        };

        console.log(requestData)

        axios.post(generateEndpoint, requestData).then(res => setItinerary(res.data));
    }

  return (
    <Box p={5}>
        <Typography variant="h2">Welcome to Wayvvy,</Typography>
        <Typography variant="h6">An AI travel bot that creates custom hour by hour itineraries for any city in the world!</Typography>

        <Box my={2}>
            <TextField
                id="outlined-controlled"
                label="City"
                value={city}
                onChange={(event) => {
                    setCity(event.target.value);
                }}
            />
        </Box>
        <Box my={2}>
            <TextField
                id="outlined-controlled"
                label="Number of days"
                value={numDays}
                onChange={(event) => {
                    setNumDays(Number(event.target.value));
                }}
            />
        </Box>
        <Box my={2}>
            <TextField
                id="outlined-controlled"
                label="List any specific locations you want to include"
                value={locations}
                onChange={(event) => {
                    setLocations(event.target.value);
                }}
                fullWidth={true}
            />
        </Box>
        <FormControlLabel
            control={
              <Checkbox 
              checked={includePrices} 
              onChange={() => setIncludePrices(prev => !prev)} 
              name="prices" />
            }
            label="Include Prices"
        />
        <FormControlLabel
            control={
              <Checkbox 
              checked={includeTransportation} 
              onChange={() => setIncludeTransportation(prev => !prev)} 
              name="transportation" />
            }
            label="Include Transportation"
        />
        <FormControlLabel
            control={
              <Checkbox 
              checked={minimizeTravel} 
              onChange={() => setMinimizeTravel(prev => !prev)} 
              name="minimizeTravel" />
            }
            label="Minimize travel distance"
        />
        <Box>
            <Button 
                variant="outlined"
                onClick={generateItinerary}
            >
                Generate
            </Button>
        </Box>


    </Box>
  );
}

export default App;

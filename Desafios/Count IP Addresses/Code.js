const FINAL_POSITION = 3;
const INITIAL = 0;

const MULTIPLIER = 256
const FOURTH_BYTE = 1
const THIRD_BYTE = MULTIPLIER * FOURTH_BYTE
const SECOND_BYTE = THIRD_BYTE * MULTIPLIER
const FIRST_BYTE = SECOND_BYTE * MULTIPLIER

function ipsBetween(start, end){
    const dividedIpsFromStart = start.split('.')
    const dividedIpsFromEnd = end.split('.')

    let countIps = INITIAL;

    for(let position = INITIAL; position <= FINAL_POSITION; position++) {
        const valueOfStart = Number(dividedIpsFromStart[position])
        const valueOfEnd = Number(dividedIpsFromEnd[position])

        const differenceBetweenValues = (valueOfEnd - valueOfStart);

        switch(position) {
            case 0:
                countIps += FIRST_BYTE * differenceBetweenValues
                break;
            case 1:
                countIps += SECOND_BYTE * differenceBetweenValues
                break;
            case 2:
                countIps += THIRD_BYTE  * differenceBetweenValues
                break;
            case 3:
                countIps += FOURTH_BYTE * differenceBetweenValues
        }
    }

    return countIps
  }

  console.log(ipsBetween('150.0.0.0', '150.0.0.1'))
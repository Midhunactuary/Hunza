import { makeStyles } from '@material-ui/core/styles';


const useStyles = makeStyles({
    btnStyle: {
        background: "rgb(0 0 0 / 60%)",
        color: "#fff",
        "&:hover, &:focus": {
            background: "rgb(0 0 0)"
        }

    }
});

export {useStyles};